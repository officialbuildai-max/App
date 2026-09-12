package tb;

import android.util.Base64;
import android.util.JsonReader;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class j {

    /* renamed from: a */
    private static final bc.a f76297a = new dc.d().j(com.google.firebase.crashlytics.internal.model.a.f31365a).k(true).i();

    /* loaded from: classes5.dex */
    public interface a {
        Object a(JsonReader jsonReader);
    }

    private static CrashlyticsReport.e.d.f A(JsonReader jsonReader) {
        CrashlyticsReport.e.d.f.a a11 = CrashlyticsReport.e.d.f.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("assignments")) {
                a11.b(n(jsonReader, new a() { // from class: tb.f
                    @Override // tb.j.a
                    public final Object a(JsonReader jsonReader2) {
                        CrashlyticsReport.e.d.AbstractC0437e z10;
                        z10 = j.z(jsonReader2);
                        return z10;
                    }
                }));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.e.d.a.b.AbstractC0429d B(JsonReader jsonReader) {
        CrashlyticsReport.e.d.a.b.AbstractC0429d.AbstractC0430a a11 = CrashlyticsReport.e.d.a.b.AbstractC0429d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1147692044:
                    if (nextName.equals(PlaceTypes.ADDRESS)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3059181:
                    if (nextName.equals("code")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals("name")) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.b(jsonReader.nextLong());
                    break;
                case 1:
                    a11.c(jsonReader.nextString());
                    break;
                case 2:
                    a11.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static CrashlyticsReport.e.d.a.b.AbstractC0431e C(JsonReader jsonReader) {
        CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0432a a11 = CrashlyticsReport.e.d.a.b.AbstractC0431e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals(com.mbridge.msdk.foundation.entity.b.JSON_KEY_FRAME_ADS)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals("name")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.b(n(jsonReader, new i()));
                    break;
                case 1:
                    a11.d(jsonReader.nextString());
                    break;
                case 2:
                    a11.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    public static CrashlyticsReport.d.b D(JsonReader jsonReader) {
        CrashlyticsReport.d.b.a a11 = CrashlyticsReport.d.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("filename")) {
                a11.c(jsonReader.nextString());
            } else if (nextName.equals("contents")) {
                a11.b(Base64.decode(jsonReader.nextString(), 2));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    private static CrashlyticsReport.d E(JsonReader jsonReader) {
        CrashlyticsReport.d.a a11 = CrashlyticsReport.d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("files")) {
                a11.b(n(jsonReader, new a() { // from class: tb.e
                    @Override // tb.j.a
                    public final Object a(JsonReader jsonReader2) {
                        CrashlyticsReport.d.b D;
                        D = j.D(jsonReader2);
                        return D;
                    }
                }));
            } else if (nextName.equals("orgId")) {
                a11.c(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.e.AbstractC0438e F(JsonReader jsonReader) {
        CrashlyticsReport.e.AbstractC0438e.a a11 = CrashlyticsReport.e.AbstractC0438e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -293026577:
                    if (nextName.equals("jailbroken")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals(TrackingKey.PLATFORM)) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.b(jsonReader.nextString());
                    break;
                case 1:
                    a11.c(jsonReader.nextBoolean());
                    break;
                case 2:
                    a11.e(jsonReader.nextString());
                    break;
                case 3:
                    a11.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static CrashlyticsReport.e.d.a.c G(JsonReader jsonReader) {
        CrashlyticsReport.e.d.a.c.AbstractC0435a a11 = CrashlyticsReport.e.d.a.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case 110987:
                    if (nextName.equals("pid")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 202325402:
                    if (nextName.equals("processName")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 1694598382:
                    if (nextName.equals("defaultProcess")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.d(jsonReader.nextInt());
                    break;
                case 1:
                    a11.e(jsonReader.nextString());
                    break;
                case 2:
                    a11.b(jsonReader.nextBoolean());
                    break;
                case 3:
                    a11.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport H(JsonReader jsonReader) {
        CrashlyticsReport.b b11 = CrashlyticsReport.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -2118372775:
                    if (nextName.equals("ndkPayload")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1962630338:
                    if (nextName.equals("sdkVersion")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1907185581:
                    if (nextName.equals("appQualitySessionId")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1375141843:
                    if (nextName.equals("appExitInfo")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -401988390:
                    if (nextName.equals("firebaseAuthenticationToken")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 344431858:
                    if (nextName.equals("gmpAppId")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 1047652060:
                    if (nextName.equals("firebaseInstallationId")) {
                        c11 = '\b';
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals(TrackingKey.PLATFORM)) {
                        c11 = '\t';
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c11 = '\n';
                        break;
                    }
                    break;
                case 1984987798:
                    if (nextName.equals("session")) {
                        c11 = 11;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    b11.j(E(jsonReader));
                    break;
                case 1:
                    b11.l(jsonReader.nextString());
                    break;
                case 2:
                    b11.c(jsonReader.nextString());
                    break;
                case 3:
                    b11.b(m(jsonReader));
                    break;
                case 4:
                    b11.d(jsonReader.nextString());
                    break;
                case 5:
                    b11.f(jsonReader.nextString());
                    break;
                case 6:
                    b11.h(jsonReader.nextString());
                    break;
                case 7:
                    b11.i(jsonReader.nextString());
                    break;
                case '\b':
                    b11.g(jsonReader.nextString());
                    break;
                case '\t':
                    b11.k(jsonReader.nextInt());
                    break;
                case '\n':
                    b11.e(jsonReader.nextString());
                    break;
                case 11:
                    b11.m(J(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return b11.a();
    }

    private static CrashlyticsReport.e.d.AbstractC0437e.b I(JsonReader jsonReader) {
        CrashlyticsReport.e.d.AbstractC0437e.b.a a11 = CrashlyticsReport.e.d.AbstractC0437e.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("variantId")) {
                a11.c(jsonReader.nextString());
            } else if (nextName.equals("rolloutId")) {
                a11.b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001a. Please report as an issue. */
    private static CrashlyticsReport.e J(JsonReader jsonReader) {
        CrashlyticsReport.e.b a11 = CrashlyticsReport.e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -2128794476:
                    if (nextName.equals("startedAt")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1907185581:
                    if (nextName.equals("appQualitySessionId")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1606742899:
                    if (nextName.equals("endedAt")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -1335157162:
                    if (nextName.equals("device")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -1291329255:
                    if (nextName.equals("events")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 3599307:
                    if (nextName.equals("user")) {
                        c11 = '\b';
                        break;
                    }
                    break;
                case 286956243:
                    if (nextName.equals("generator")) {
                        c11 = '\t';
                        break;
                    }
                    break;
                case 1025385094:
                    if (nextName.equals("crashed")) {
                        c11 = '\n';
                        break;
                    }
                    break;
                case 2047016109:
                    if (nextName.equals("generatorType")) {
                        c11 = 11;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.m(jsonReader.nextLong());
                    break;
                case 1:
                    a11.c(jsonReader.nextString());
                    break;
                case 2:
                    a11.k(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 3:
                    a11.f(Long.valueOf(jsonReader.nextLong()));
                    break;
                case 4:
                    a11.e(q(jsonReader));
                    break;
                case 5:
                    a11.g(n(jsonReader, new a() { // from class: tb.d
                        @Override // tb.j.a
                        public final Object a(JsonReader jsonReader2) {
                            CrashlyticsReport.e.d r11;
                            r11 = j.r(jsonReader2);
                            return r11;
                        }
                    }));
                    break;
                case 6:
                    a11.l(F(jsonReader));
                    break;
                case 7:
                    a11.b(l(jsonReader));
                    break;
                case '\b':
                    a11.n(K(jsonReader));
                    break;
                case '\t':
                    a11.h(jsonReader.nextString());
                    break;
                case '\n':
                    a11.d(jsonReader.nextBoolean());
                    break;
                case 11:
                    a11.i(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    private static CrashlyticsReport.e.f K(JsonReader jsonReader) {
        CrashlyticsReport.e.f.a a11 = CrashlyticsReport.e.f.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals("identifier")) {
                a11.b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.e.a l(JsonReader jsonReader) {
        CrashlyticsReport.e.a.AbstractC0423a a11 = CrashlyticsReport.e.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -519438642:
                    if (nextName.equals("developmentPlatform")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 213652010:
                    if (nextName.equals("developmentPlatformVersion")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c11 = 5;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.e(jsonReader.nextString());
                    break;
                case 1:
                    a11.b(jsonReader.nextString());
                    break;
                case 2:
                    a11.c(jsonReader.nextString());
                    break;
                case 3:
                    a11.g(jsonReader.nextString());
                    break;
                case 4:
                    a11.f(jsonReader.nextString());
                    break;
                case 5:
                    a11.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.a m(JsonReader jsonReader) {
        CrashlyticsReport.a.b a11 = CrashlyticsReport.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1516200806:
                    if (nextName.equals("buildIdMappingForArch")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 110987:
                    if (nextName.equals("pid")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 111312:
                    if (nextName.equals("pss")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 113234:
                    if (nextName.equals("rss")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals(CampaignEx.JSON_KEY_TIMESTAMP)) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 202325402:
                    if (nextName.equals("processName")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 722137681:
                    if (nextName.equals("reasonCode")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 723857505:
                    if (nextName.equals("traceFile")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c11 = '\b';
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.b(n(jsonReader, new a() { // from class: tb.a
                        @Override // tb.j.a
                        public final Object a(JsonReader jsonReader2) {
                            CrashlyticsReport.a.AbstractC0421a o11;
                            o11 = j.o(jsonReader2);
                            return o11;
                        }
                    }));
                    break;
                case 1:
                    a11.d(jsonReader.nextInt());
                    break;
                case 2:
                    a11.f(jsonReader.nextLong());
                    break;
                case 3:
                    a11.h(jsonReader.nextLong());
                    break;
                case 4:
                    a11.i(jsonReader.nextLong());
                    break;
                case 5:
                    a11.e(jsonReader.nextString());
                    break;
                case 6:
                    a11.g(jsonReader.nextInt());
                    break;
                case 7:
                    a11.j(jsonReader.nextString());
                    break;
                case '\b':
                    a11.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    private static List n(JsonReader jsonReader, a aVar) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(aVar.a(jsonReader));
        }
        jsonReader.endArray();
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static CrashlyticsReport.a.AbstractC0421a o(JsonReader jsonReader) {
        CrashlyticsReport.a.AbstractC0421a.AbstractC0422a a11 = CrashlyticsReport.a.AbstractC0421a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -609862170:
                    if (nextName.equals("libraryName")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 230943785:
                    if (nextName.equals("buildId")) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.d(jsonReader.nextString());
                    break;
                case 1:
                    a11.b(jsonReader.nextString());
                    break;
                case 2:
                    a11.c(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    public static CrashlyticsReport.c p(JsonReader jsonReader) {
        CrashlyticsReport.c.a a11 = CrashlyticsReport.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("key")) {
                a11.b(jsonReader.nextString());
            } else if (nextName.equals(AppMeasurementSdk.ConditionalUserProperty.VALUE)) {
                a11.c(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.e.c q(JsonReader jsonReader) {
        CrashlyticsReport.e.c.a a11 = CrashlyticsReport.e.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1981332476:
                    if (nextName.equals("simulator")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1969347631:
                    if (nextName.equals("manufacturer")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 112670:
                    if (nextName.equals("ram")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 81784169:
                    if (nextName.equals("diskSpace")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 94848180:
                    if (nextName.equals("cores")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 104069929:
                    if (nextName.equals("model")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 109757585:
                    if (nextName.equals("state")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 2078953423:
                    if (nextName.equals("modelClass")) {
                        c11 = '\b';
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.i(jsonReader.nextBoolean());
                    break;
                case 1:
                    a11.e(jsonReader.nextString());
                    break;
                case 2:
                    a11.h(jsonReader.nextLong());
                    break;
                case 3:
                    a11.b(jsonReader.nextInt());
                    break;
                case 4:
                    a11.d(jsonReader.nextLong());
                    break;
                case 5:
                    a11.c(jsonReader.nextInt());
                    break;
                case 6:
                    a11.f(jsonReader.nextString());
                    break;
                case 7:
                    a11.j(jsonReader.nextInt());
                    break;
                case '\b':
                    a11.g(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static CrashlyticsReport.e.d r(JsonReader jsonReader) {
        CrashlyticsReport.e.d.b a11 = CrashlyticsReport.e.d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1335157162:
                    if (nextName.equals("device")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -259312414:
                    if (nextName.equals("rollouts")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 107332:
                    if (nextName.equals("log")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals(NativeComponentConstants.KEY_COMPONENT_TYPE)) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals(CampaignEx.JSON_KEY_TIMESTAMP)) {
                        c11 = 5;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.c(u(jsonReader));
                    break;
                case 1:
                    a11.e(A(jsonReader));
                    break;
                case 2:
                    a11.b(s(jsonReader));
                    break;
                case 3:
                    a11.d(y(jsonReader));
                    break;
                case 4:
                    a11.g(jsonReader.nextString());
                    break;
                case 5:
                    a11.f(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.e.d.a s(JsonReader jsonReader) {
        CrashlyticsReport.e.d.a.AbstractC0424a a11 = CrashlyticsReport.e.d.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1405314732:
                    if (nextName.equals("appProcessDetails")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1332194002:
                    if (nextName.equals("background")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1090974952:
                    if (nextName.equals("execution")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -80231855:
                    if (nextName.equals("internalKeys")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 555169704:
                    if (nextName.equals("customAttributes")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 928737948:
                    if (nextName.equals("uiOrientation")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 1847730860:
                    if (nextName.equals("currentProcessDetails")) {
                        c11 = 6;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.b(n(jsonReader, new a() { // from class: tb.c
                        @Override // tb.j.a
                        public final Object a(JsonReader jsonReader2) {
                            CrashlyticsReport.e.d.a.c G;
                            G = j.G(jsonReader2);
                            return G;
                        }
                    }));
                    break;
                case 1:
                    a11.c(Boolean.valueOf(jsonReader.nextBoolean()));
                    break;
                case 2:
                    a11.f(v(jsonReader));
                    break;
                case 3:
                    a11.g(n(jsonReader, new a() { // from class: tb.b
                        @Override // tb.j.a
                        public final Object a(JsonReader jsonReader2) {
                            CrashlyticsReport.c p11;
                            p11 = j.p(jsonReader2);
                            return p11;
                        }
                    }));
                    break;
                case 4:
                    a11.e(n(jsonReader, new a() { // from class: tb.b
                        @Override // tb.j.a
                        public final Object a(JsonReader jsonReader2) {
                            CrashlyticsReport.c p11;
                            p11 = j.p(jsonReader2);
                            return p11;
                        }
                    }));
                    break;
                case 5:
                    a11.h(jsonReader.nextInt());
                    break;
                case 6:
                    a11.d(G(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001a. Please report as an issue. */
    public static CrashlyticsReport.e.d.a.b.AbstractC0425a t(JsonReader jsonReader) {
        CrashlyticsReport.e.d.a.b.AbstractC0425a.AbstractC0426a a11 = CrashlyticsReport.e.d.a.b.AbstractC0425a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case 3373707:
                    if (nextName.equals("name")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals("size")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3601339:
                    if (nextName.equals("uuid")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1153765347:
                    if (nextName.equals("baseAddress")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.c(jsonReader.nextString());
                    break;
                case 1:
                    a11.d(jsonReader.nextLong());
                    break;
                case 2:
                    a11.f(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 3:
                    a11.b(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.e.d.c u(JsonReader jsonReader) {
        CrashlyticsReport.e.d.c.a a11 = CrashlyticsReport.e.d.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1708606089:
                    if (nextName.equals("batteryLevel")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1455558134:
                    if (nextName.equals("batteryVelocity")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1439500848:
                    if (nextName.equals("orientation")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 279795450:
                    if (nextName.equals("diskUsed")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 976541947:
                    if (nextName.equals("ramUsed")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 1516795582:
                    if (nextName.equals("proximityOn")) {
                        c11 = 5;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.b(Double.valueOf(jsonReader.nextDouble()));
                    break;
                case 1:
                    a11.c(jsonReader.nextInt());
                    break;
                case 2:
                    a11.e(jsonReader.nextInt());
                    break;
                case 3:
                    a11.d(jsonReader.nextLong());
                    break;
                case 4:
                    a11.g(jsonReader.nextLong());
                    break;
                case 5:
                    a11.f(jsonReader.nextBoolean());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.e.d.a.b v(JsonReader jsonReader) {
        CrashlyticsReport.e.d.a.b.AbstractC0427b a11 = CrashlyticsReport.e.d.a.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1375141843:
                    if (nextName.equals("appExitInfo")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1337936983:
                    if (nextName.equals("threads")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -902467928:
                    if (nextName.equals("signal")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 937615455:
                    if (nextName.equals("binaries")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 1481625679:
                    if (nextName.equals("exception")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.b(m(jsonReader));
                    break;
                case 1:
                    a11.f(n(jsonReader, new a() { // from class: tb.g
                        @Override // tb.j.a
                        public final Object a(JsonReader jsonReader2) {
                            CrashlyticsReport.e.d.a.b.AbstractC0431e C;
                            C = j.C(jsonReader2);
                            return C;
                        }
                    }));
                    break;
                case 2:
                    a11.e(B(jsonReader));
                    break;
                case 3:
                    a11.c(n(jsonReader, new a() { // from class: tb.h
                        @Override // tb.j.a
                        public final Object a(JsonReader jsonReader2) {
                            CrashlyticsReport.e.d.a.b.AbstractC0425a t11;
                            t11 = j.t(jsonReader2);
                            return t11;
                        }
                    }));
                    break;
                case 4:
                    a11.d(w(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.e.d.a.b.c w(JsonReader jsonReader) {
        CrashlyticsReport.e.d.a.b.c.AbstractC0428a a11 = CrashlyticsReport.e.d.a.b.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals(com.mbridge.msdk.foundation.entity.b.JSON_KEY_FRAME_ADS)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -934964668:
                    if (nextName.equals("reason")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals(NativeComponentConstants.KEY_COMPONENT_TYPE)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 91997906:
                    if (nextName.equals("causedBy")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 581754413:
                    if (nextName.equals("overflowCount")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.c(n(jsonReader, new i()));
                    break;
                case 1:
                    a11.e(jsonReader.nextString());
                    break;
                case 2:
                    a11.f(jsonReader.nextString());
                    break;
                case 3:
                    a11.b(w(jsonReader));
                    break;
                case 4:
                    a11.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b x(JsonReader jsonReader) {
        CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.AbstractC0434a a11 = CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1019779949:
                    if (nextName.equals("offset")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -887523944:
                    if (nextName.equals("symbol")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3571:
                    if (nextName.equals("pc")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 3143036:
                    if (nextName.equals(OfflineConstantsKt.OFFLINE_DOWNLOAD_SEARCH_MODE_FILE)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.d(jsonReader.nextLong());
                    break;
                case 1:
                    a11.f(jsonReader.nextString());
                    break;
                case 2:
                    a11.e(jsonReader.nextLong());
                    break;
                case 3:
                    a11.b(jsonReader.nextString());
                    break;
                case 4:
                    a11.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    private static CrashlyticsReport.e.d.AbstractC0436d y(JsonReader jsonReader) {
        CrashlyticsReport.e.d.AbstractC0436d.a a11 = CrashlyticsReport.e.d.AbstractC0436d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals("content")) {
                a11.b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static CrashlyticsReport.e.d.AbstractC0437e z(JsonReader jsonReader) {
        CrashlyticsReport.e.d.AbstractC0437e.a a11 = CrashlyticsReport.e.d.AbstractC0437e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1536268810:
                    if (nextName.equals("parameterKey")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1027290370:
                    if (nextName.equals("templateVersion")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 1098747284:
                    if (nextName.equals("rolloutVariant")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1124454216:
                    if (nextName.equals("parameterValue")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a11.b(jsonReader.nextString());
                    break;
                case 1:
                    a11.e(jsonReader.nextLong());
                    break;
                case 2:
                    a11.d(I(jsonReader));
                    break;
                case 3:
                    a11.c(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a11.a();
    }

    public CrashlyticsReport L(String str) {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                CrashlyticsReport H = H(jsonReader);
                jsonReader.close();
                return H;
            } finally {
            }
        } catch (IllegalStateException e11) {
            throw new IOException(e11);
        }
    }

    public String M(CrashlyticsReport crashlyticsReport) {
        return f76297a.b(crashlyticsReport);
    }

    public CrashlyticsReport.e.d j(String str) {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                CrashlyticsReport.e.d r11 = r(jsonReader);
                jsonReader.close();
                return r11;
            } finally {
            }
        } catch (IllegalStateException e11) {
            throw new IOException(e11);
        }
    }

    public String k(CrashlyticsReport.e.d dVar) {
        return f76297a.b(dVar);
    }
}
