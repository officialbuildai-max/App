package z4;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.TimeZone;
import okhttp3.internal.connection.RealConnection;

/* loaded from: classes3.dex */
public class y1 extends e implements a5.z0, a5.a0, b2 {

    /* renamed from: a, reason: collision with root package name */
    public static final y1 f79380a = new y1();

    /* renamed from: b, reason: collision with root package name */
    private static final DateTimeFormatter f79381b;

    /* renamed from: c, reason: collision with root package name */
    private static final DateTimeFormatter f79382c;

    /* renamed from: d, reason: collision with root package name */
    private static final DateTimeFormatter f79383d;

    /* renamed from: e, reason: collision with root package name */
    private static final DateTimeFormatter f79384e;

    /* renamed from: f, reason: collision with root package name */
    private static final DateTimeFormatter f79385f;

    /* renamed from: g, reason: collision with root package name */
    private static final DateTimeFormatter f79386g;

    /* renamed from: h, reason: collision with root package name */
    private static final DateTimeFormatter f79387h;

    /* renamed from: i, reason: collision with root package name */
    private static final DateTimeFormatter f79388i;

    /* renamed from: j, reason: collision with root package name */
    private static final DateTimeFormatter f79389j;

    /* renamed from: k, reason: collision with root package name */
    private static final DateTimeFormatter f79390k;

    /* renamed from: l, reason: collision with root package name */
    private static final DateTimeFormatter f79391l;

    /* renamed from: m, reason: collision with root package name */
    private static final DateTimeFormatter f79392m;

    /* renamed from: n, reason: collision with root package name */
    private static final DateTimeFormatter f79393n;

    /* renamed from: o, reason: collision with root package name */
    private static final DateTimeFormatter f79394o;

    /* renamed from: p, reason: collision with root package name */
    private static final DateTimeFormatter f79395p;

    /* renamed from: q, reason: collision with root package name */
    private static final DateTimeFormatter f79396q;

    /* renamed from: r, reason: collision with root package name */
    private static final DateTimeFormatter f79397r;

    /* renamed from: s, reason: collision with root package name */
    private static final DateTimeFormatter f79398s;

    /* renamed from: t, reason: collision with root package name */
    private static final DateTimeFormatter f79399t;

    /* renamed from: u, reason: collision with root package name */
    private static final DateTimeFormatter f79400u;

    static {
        DateTimeFormatter ofPattern;
        DateTimeFormatter ofPattern2;
        DateTimeFormatter ofPattern3;
        DateTimeFormatter ofPattern4;
        DateTimeFormatter ofPattern5;
        DateTimeFormatter ofPattern6;
        DateTimeFormatter ofPattern7;
        DateTimeFormatter ofPattern8;
        DateTimeFormatter ofPattern9;
        DateTimeFormatter ofPattern10;
        DateTimeFormatter ofPattern11;
        DateTimeFormatter ofPattern12;
        DateTimeFormatter ofPattern13;
        DateTimeFormatter ofPattern14;
        DateTimeFormatter ofPattern15;
        DateTimeFormatter ofPattern16;
        DateTimeFormatter ofPattern17;
        DateTimeFormatter ofPattern18;
        DateTimeFormatter ofPattern19;
        ZoneId systemDefault;
        DateTimeFormatter withZone;
        DateTimeFormatter ofPattern20;
        ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        f79381b = ofPattern;
        ofPattern2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        f79382c = ofPattern2;
        ofPattern3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        f79383d = ofPattern3;
        ofPattern4 = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");
        f79384e = ofPattern4;
        ofPattern5 = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");
        f79385f = ofPattern5;
        ofPattern6 = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");
        f79386g = ofPattern6;
        ofPattern7 = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        f79387h = ofPattern7;
        ofPattern8 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        f79388i = ofPattern8;
        ofPattern9 = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        f79389j = ofPattern9;
        ofPattern10 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        f79390k = ofPattern10;
        ofPattern11 = DateTimeFormatter.ofPattern("yyyyMMdd");
        f79391l = ofPattern11;
        ofPattern12 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        f79392m = ofPattern12;
        ofPattern13 = DateTimeFormatter.ofPattern("yyyy年M月d日");
        f79393n = ofPattern13;
        ofPattern14 = DateTimeFormatter.ofPattern("yyyy년M월d일");
        f79394o = ofPattern14;
        ofPattern15 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        f79395p = ofPattern15;
        ofPattern16 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        f79396q = ofPattern16;
        ofPattern17 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        f79397r = ofPattern17;
        ofPattern18 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        f79398s = ofPattern18;
        ofPattern19 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        systemDefault = ZoneId.systemDefault();
        withZone = ofPattern19.withZone(systemDefault);
        f79399t = withZone;
        ofPattern20 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        f79400u = ofPattern20;
    }

    public static Object f(Object obj, String str) {
        DateTimeFormatter ofPattern;
        LocalDateTime parse;
        if (obj == null) {
            return null;
        }
        if (str == null) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        ofPattern = DateTimeFormatter.ofPattern(str);
        parse = LocalDateTime.parse(obj.toString(), ofPattern);
        return parse;
    }

    private void j(a5.j1 j1Var, TemporalAccessor temporalAccessor, String str) {
        String format;
        Instant instant;
        ZoneId zoneId;
        ZonedDateTime atZone;
        long epochMilli;
        ZoneId zoneId2;
        ZonedDateTime atZone2;
        long epochSecond;
        if ("unixtime".equals(str)) {
            if (m1.a(temporalAccessor)) {
                epochSecond = p1.a(temporalAccessor).toEpochSecond();
                j1Var.h0((int) epochSecond);
                return;
            } else if (n1.a(temporalAccessor)) {
                LocalDateTime a11 = i1.a(temporalAccessor);
                zoneId2 = com.alibaba.fastjson.a.defaultTimeZone.toZoneId();
                atZone2 = a11.atZone(zoneId2);
                j1Var.h0((int) atZone2.toEpochSecond());
                return;
            }
        }
        if ("millis".equals(str)) {
            if (m1.a(temporalAccessor)) {
                instant = p1.a(temporalAccessor).toInstant();
            } else if (n1.a(temporalAccessor)) {
                LocalDateTime a12 = i1.a(temporalAccessor);
                zoneId = com.alibaba.fastjson.a.defaultTimeZone.toZoneId();
                atZone = a12.atZone(zoneId);
                instant = atZone.toInstant();
            } else {
                instant = null;
            }
            if (instant != null) {
                epochMilli = instant.toEpochMilli();
                j1Var.l0(epochMilli);
                return;
            }
        }
        format = (str == "yyyy-MM-dd'T'HH:mm:ss" ? f79400u : DateTimeFormatter.ofPattern(str)).format(temporalAccessor);
        j1Var.q0(format);
    }

    @Override // a5.a0
    public void a(a5.o0 o0Var, Object obj, a5.p pVar) {
        j(o0Var.f371k, x1.a(obj), pVar.b());
    }

    @Override // z4.b2
    public int b() {
        return 4;
    }

    @Override // a5.z0
    public void d(a5.o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        ZoneId zoneId;
        ZonedDateTime atZone;
        long epochMilli;
        int nano;
        a5.j1 j1Var = o0Var.f371k;
        if (obj == null) {
            j1Var.m0();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type != x0.a()) {
            j1Var.q0(obj.toString());
            return;
        }
        SerializerFeature serializerFeature = SerializerFeature.UseISO8601DateFormat;
        int mask = serializerFeature.getMask();
        LocalDateTime a11 = i1.a(obj);
        String o11 = o0Var.o();
        if (o11 == null) {
            o11 = "yyyy-MM-dd'T'HH:mm:ss";
            if ((i11 & mask) == 0 && !o0Var.t(serializerFeature)) {
                if (o0Var.t(SerializerFeature.WriteDateUseDateFormat)) {
                    o11 = (o0Var.p() == null || o0Var.p().length() <= 0) ? com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT : o0Var.p();
                } else {
                    nano = a11.getNano();
                    if (nano != 0) {
                        o11 = nano % 1000000 == 0 ? "yyyy-MM-dd'T'HH:mm:ss.SSS" : "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
                    }
                }
            }
        }
        if (o11 != null) {
            j(j1Var, a11, o11);
            return;
        }
        zoneId = com.alibaba.fastjson.a.defaultTimeZone.toZoneId();
        atZone = a11.atZone(zoneId);
        epochMilli = atZone.toInstant().toEpochMilli();
        j1Var.l0(epochMilli);
    }

    @Override // z4.e
    public Object e(y4.a aVar, Type type, Object obj, String str, int i11) {
        Long l11;
        Duration ofSeconds;
        Instant ofEpochSecond;
        Instant ofEpochSecond2;
        LocalDateTime of2;
        Instant ofEpochMilli;
        Instant ofEpochMilli2;
        ZoneId zoneId;
        ZonedDateTime ofInstant;
        Instant ofEpochMilli3;
        ZoneId zoneId2;
        LocalDateTime ofInstant2;
        LocalTime localTime;
        Instant ofEpochMilli4;
        ZoneId zoneId3;
        LocalDateTime ofInstant3;
        LocalDate localDate;
        Instant ofEpochMilli5;
        ZoneId zoneId4;
        LocalDateTime ofInstant4;
        Instant ofEpochMilli6;
        Instant parse;
        Duration parse2;
        Period parse3;
        ZoneId of3;
        OffsetTime parse4;
        OffsetDateTime parse5;
        Instant instant;
        ZoneId zoneId5;
        ZonedDateTime ofInstant5;
        Instant ofEpochMilli7;
        ZoneId zoneId6;
        LocalDateTime ofInstant6;
        LocalTime localTime2;
        LocalTime parse6;
        LocalDateTime parse7;
        int hour;
        int minute;
        int second;
        int nano;
        LocalTime of4;
        LocalDateTime parse8;
        int year;
        int monthValue;
        int dayOfMonth;
        LocalDate of5;
        LocalTime localTime3;
        LocalDateTime of6;
        y4.b bVar = aVar.f78954f;
        if (bVar.q0() == 8) {
            bVar.Z();
            return null;
        }
        if (bVar.q0() == 4) {
            String k02 = bVar.k0();
            bVar.Z();
            DateTimeFormatter ofPattern = str != null ? "yyyy-MM-dd HH:mm:ss".equals(str) ? f79381b : DateTimeFormatter.ofPattern(str) : null;
            if ("".equals(k02)) {
                return null;
            }
            if (type == x0.a()) {
                if (k02.length() != 10 && k02.length() != 8) {
                    return g(k02, ofPattern);
                }
                LocalDate h11 = h(k02, str, ofPattern);
                localTime3 = LocalTime.MIN;
                of6 = LocalDateTime.of(h11, localTime3);
                return of6;
            }
            if (type == w0.a()) {
                if (k02.length() != 23) {
                    return h(k02, str, ofPattern);
                }
                parse8 = LocalDateTime.parse(k02);
                year = parse8.getYear();
                monthValue = parse8.getMonthValue();
                dayOfMonth = parse8.getDayOfMonth();
                of5 = LocalDate.of(year, monthValue, dayOfMonth);
                return of5;
            }
            int i12 = 0;
            if (type == s.a()) {
                if (k02.length() == 23) {
                    parse7 = LocalDateTime.parse(k02);
                    hour = parse7.getHour();
                    minute = parse7.getMinute();
                    second = parse7.getSecond();
                    nano = parse7.getNano();
                    of4 = LocalTime.of(hour, minute, second, nano);
                    return of4;
                }
                while (true) {
                    if (i12 < k02.length()) {
                        char charAt = k02.charAt(i12);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i12++;
                    } else if (k02.length() > 8 && k02.length() < 19) {
                        ofEpochMilli7 = Instant.ofEpochMilli(Long.parseLong(k02));
                        zoneId6 = com.alibaba.fastjson.a.defaultTimeZone.toZoneId();
                        ofInstant6 = LocalDateTime.ofInstant(ofEpochMilli7, zoneId6);
                        localTime2 = ofInstant6.toLocalTime();
                        return localTime2;
                    }
                }
                parse6 = LocalTime.parse(k02);
                return parse6;
            }
            if (type == d0.a()) {
                if (ofPattern == f79381b) {
                    ofPattern = f79399t;
                }
                if (ofPattern == null && k02.length() <= 19) {
                    y4.e eVar = new y4.e(k02);
                    TimeZone l02 = aVar.f78954f.l0();
                    eVar.o1(l02);
                    if (eVar.x1(false)) {
                        instant = eVar.J0().getTime().toInstant();
                        zoneId5 = l02.toZoneId();
                        ofInstant5 = ZonedDateTime.ofInstant(instant, zoneId5);
                        return ofInstant5;
                    }
                }
                return i(k02, ofPattern);
            }
            if (type == g0.a()) {
                parse5 = OffsetDateTime.parse(k02);
                return parse5;
            }
            if (type == i0.a()) {
                parse4 = OffsetTime.parse(k02);
                return parse4;
            }
            if (type == l0.a()) {
                of3 = ZoneId.of(k02);
                return of3;
            }
            if (type == o0.a()) {
                parse3 = Period.parse(k02);
                return parse3;
            }
            if (type == q0.a()) {
                parse2 = Duration.parse(k02);
                return parse2;
            }
            if (type == s0.a()) {
                while (true) {
                    if (i12 < k02.length()) {
                        char charAt2 = k02.charAt(i12);
                        if (charAt2 < '0' || charAt2 > '9') {
                            break;
                        }
                        i12++;
                    } else if (k02.length() > 8 && k02.length() < 19) {
                        ofEpochMilli6 = Instant.ofEpochMilli(Long.parseLong(k02));
                        return ofEpochMilli6;
                    }
                }
                parse = Instant.parse(k02);
                return parse;
            }
        } else {
            if (bVar.q0() == 2) {
                long l12 = bVar.l();
                bVar.Z();
                if ("unixtime".equals(str)) {
                    l12 *= 1000;
                } else if ("yyyyMMddHHmmss".equals(str)) {
                    int i13 = (int) (l12 / RealConnection.IDLE_CONNECTION_HEALTHY_NS);
                    int i14 = (int) ((l12 / 100000000) % 100);
                    int i15 = (int) ((l12 / 1000000) % 100);
                    int i16 = (int) ((l12 / 10000) % 100);
                    int i17 = (int) ((l12 / 100) % 100);
                    int i18 = (int) (l12 % 100);
                    if (type == x0.a()) {
                        of2 = LocalDateTime.of(i13, i14, i15, i16, i17, i18);
                        return of2;
                    }
                }
                if (type == x0.a()) {
                    ofEpochMilli5 = Instant.ofEpochMilli(l12);
                    zoneId4 = com.alibaba.fastjson.a.defaultTimeZone.toZoneId();
                    ofInstant4 = LocalDateTime.ofInstant(ofEpochMilli5, zoneId4);
                    return ofInstant4;
                }
                if (type == w0.a()) {
                    ofEpochMilli4 = Instant.ofEpochMilli(l12);
                    zoneId3 = com.alibaba.fastjson.a.defaultTimeZone.toZoneId();
                    ofInstant3 = LocalDateTime.ofInstant(ofEpochMilli4, zoneId3);
                    localDate = ofInstant3.toLocalDate();
                    return localDate;
                }
                if (type == s.a()) {
                    ofEpochMilli3 = Instant.ofEpochMilli(l12);
                    zoneId2 = com.alibaba.fastjson.a.defaultTimeZone.toZoneId();
                    ofInstant2 = LocalDateTime.ofInstant(ofEpochMilli3, zoneId2);
                    localTime = ofInstant2.toLocalTime();
                    return localTime;
                }
                if (type == d0.a()) {
                    ofEpochMilli2 = Instant.ofEpochMilli(l12);
                    zoneId = com.alibaba.fastjson.a.defaultTimeZone.toZoneId();
                    ofInstant = ZonedDateTime.ofInstant(ofEpochMilli2, zoneId);
                    return ofInstant;
                }
                if (type != s0.a()) {
                    throw new UnsupportedOperationException();
                }
                ofEpochMilli = Instant.ofEpochMilli(l12);
                return ofEpochMilli;
            }
            if (bVar.q0() != 12) {
                throw new UnsupportedOperationException();
            }
            JSONObject l03 = aVar.l0();
            if (type == s0.a()) {
                Object obj2 = l03.get("epochSecond");
                Object obj3 = l03.get("nano");
                boolean z10 = obj2 instanceof Number;
                if (z10 && (obj3 instanceof Number)) {
                    ofEpochSecond2 = Instant.ofEpochSecond(TypeUtils.D0((Number) obj2), TypeUtils.D0((Number) obj3));
                    return ofEpochSecond2;
                }
                if (z10) {
                    ofEpochSecond = Instant.ofEpochSecond(TypeUtils.D0((Number) obj2));
                    return ofEpochSecond;
                }
            } else if (type == q0.a() && (l11 = l03.getLong("seconds")) != null) {
                ofSeconds = Duration.ofSeconds(l11.longValue(), l03.getLongValue("nano"));
                return ofSeconds;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.time.LocalDateTime g(java.lang.String r17, java.time.format.DateTimeFormatter r18) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.y1.g(java.lang.String, java.time.format.DateTimeFormatter):java.time.LocalDateTime");
    }

    protected LocalDate h(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        LocalDate parse;
        LocalDate parse2;
        Instant ofEpochMilli;
        ZoneId zoneId;
        LocalDateTime ofInstant;
        LocalDate localDate;
        DateTimeFormatter dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = f79391l;
            }
            int i11 = 0;
            if (str.length() == 10) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                if (charAt == '/' && charAt2 == '/') {
                    dateTimeFormatter = f79392m;
                }
                char charAt3 = str.charAt(0);
                char charAt4 = str.charAt(1);
                char charAt5 = str.charAt(2);
                char charAt6 = str.charAt(3);
                char charAt7 = str.charAt(5);
                if (charAt5 == '/' && charAt7 == '/') {
                    int i12 = ((charAt6 - '0') * 10) + (charAt - '0');
                    if (((charAt3 - '0') * 10) + (charAt4 - '0') > 12) {
                        dateTimeFormatter3 = f79396q;
                    } else if (i12 > 12) {
                        dateTimeFormatter3 = f79395p;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter3 = f79395p;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter3 = f79396q;
                        }
                    }
                    dateTimeFormatter = dateTimeFormatter3;
                } else if (charAt5 == '.' && charAt7 == '.') {
                    dateTimeFormatter = f79397r;
                } else if (charAt5 == '-' && charAt7 == '-') {
                    dateTimeFormatter = f79398s;
                }
            }
            if (str.length() >= 9) {
                char charAt8 = str.charAt(4);
                if (charAt8 == 24180) {
                    dateTimeFormatter2 = f79393n;
                } else if (charAt8 == 45380) {
                    dateTimeFormatter2 = f79394o;
                }
                dateTimeFormatter = dateTimeFormatter2;
            }
            while (true) {
                if (i11 < str.length()) {
                    char charAt9 = str.charAt(i11);
                    if (charAt9 < '0' || charAt9 > '9') {
                        break;
                    }
                    i11++;
                } else if (str.length() > 8 && str.length() < 19) {
                    ofEpochMilli = Instant.ofEpochMilli(Long.parseLong(str));
                    zoneId = com.alibaba.fastjson.a.defaultTimeZone.toZoneId();
                    ofInstant = LocalDateTime.ofInstant(ofEpochMilli, zoneId);
                    localDate = ofInstant.toLocalDate();
                    return localDate;
                }
            }
        }
        if (dateTimeFormatter == null) {
            parse2 = LocalDate.parse(str);
            return parse2;
        }
        parse = LocalDate.parse(str, dateTimeFormatter);
        return parse;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.time.ZonedDateTime i(java.lang.String r16, java.time.format.DateTimeFormatter r17) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.y1.i(java.lang.String, java.time.format.DateTimeFormatter):java.time.ZonedDateTime");
    }
}
